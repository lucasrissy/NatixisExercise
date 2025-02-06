package com.natixis.EasyPay.serviceTest;

import com.natixis.EasyPay.dto.ScheduleDto;
import com.natixis.EasyPay.entity.ScheduleEntity;
import com.natixis.EasyPay.exception.InvalidDateException;
import com.natixis.EasyPay.exception.ResourceNotFound;
import com.natixis.EasyPay.mapper.ScheduleMapper;
import com.natixis.EasyPay.repository.ScheduleRepository;
import com.natixis.EasyPay.service.ScheduleService;
import com.natixis.EasyPay.service.factory.FeeFactory;
import com.natixis.EasyPay.service.interfaces.TransferFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTest {

    @InjectMocks
    private ScheduleService service;

    @Mock
    private ScheduleRepository repository;
    @Mock
    private TransferFee transferFee;
    @Mock
    private ScheduleMapper scheduleMapper;

    @Captor
    private ArgumentCaptor<ScheduleEntity> scheduleEntityCaptor;


    private ScheduleEntity schedule;
    private ScheduleDto scheduleDto;
    private BigDecimal finalValue;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        schedule = new ScheduleEntity(1L, 101L, new BigDecimal("500.00"), LocalDate.now(), new BigDecimal("515.00"));
        scheduleDto = new ScheduleDto(101L, new BigDecimal("500.00"), LocalDate.now(), new BigDecimal("515.00"));
        finalValue = new BigDecimal("518.00");
    }

    @Test
    public void shouldReturnSchedulingWhenExists() {
        when(repository.findById(1L)).thenReturn(Optional.of(schedule));

        ScheduleDto result = service.getSchedulingById(1L);

        assertNotNull(result);
        assertEquals(scheduleDto.getClientId(), result.getClientId());
        assertEquals(scheduleDto.getAmount(), result.getAmount());
    }

    @Test
    public void shouldThrowResourceNotFoundWhenSchedulingDoesNotExist() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFound exception = assertThrows(ResourceNotFound.class, () -> {
            service.getSchedulingById(1L);
        });

        assertEquals("Resource not found not found with the given input data id : '1'", exception.getMessage());
    }

    @Test
    public void shouldCreateSchedulingSuccessfullyWhenDtoIsValid() {
        BigDecimal expectedFinalValue = new BigDecimal("518.00");

        when(transferFee.calculate(scheduleDto.getAmount(), scheduleDto.getScheduleDate()))
                .thenReturn(expectedFinalValue);


        try (MockedStatic<FeeFactory> mockedStatic = mockStatic(FeeFactory.class)) {
            mockedStatic.when(() -> FeeFactory.getFeeStrategy(scheduleDto.getAmount(), scheduleDto.getScheduleDate())).thenReturn(transferFee);


            ScheduleDto result = service.createScheduling(scheduleDto);


            verify(repository).save(scheduleEntityCaptor.capture());

            ScheduleEntity savedEntity = scheduleEntityCaptor.getValue();

            assertEquals(expectedFinalValue, result.getFinalValue());
            assertEquals(scheduleDto.getAmount(), savedEntity.getAmount());
            assertEquals(expectedFinalValue, savedEntity.getFinalValue());
            assertEquals(scheduleDto.getScheduleDate(), savedEntity.getScheduleDate());

        }
    }

    @Test
    public void shouldThrowExceptionWhenDtoIsInvalid() {

        ScheduleDto invalidScheduleDto = new ScheduleDto();
        invalidScheduleDto.setAmount(null);
        invalidScheduleDto.setScheduleDate(LocalDate.of(2023,01,01));



        try (MockedStatic<FeeFactory> mockedStatic = mockStatic(FeeFactory.class)) {
            mockedStatic.when(() -> FeeFactory.getFeeStrategy(invalidScheduleDto.getAmount(),invalidScheduleDto.getScheduleDate())).thenReturn(transferFee);

            assertThrows(IllegalArgumentException.class, () -> {
                service.createScheduling(invalidScheduleDto);
            });
        }
    }

}


