package com.example.test_easy_bot.infrastructure;

import com.example.test_easy_bot.enums.ProductTypeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCreationRequest {
    @NotNull
    private ProductTypeEnum type;

    @NotNull
    @Size(max = 50)
    private String serialNumber;

    @NotNull
    @Size(max = 50)
    private String manufacturer;

    @NotNull
    @Positive
    private Long price;

    @NotNull
    @Positive
    private Integer amount;

    @Size(max = 50)
    private String pcFormFactor;

    @Size(max = 50)
    private String laptopScreenSize;

    @Size(max = 50)
    private String screenSize;

    @Size(max = 50)
    private String hardDiskSize;
}
