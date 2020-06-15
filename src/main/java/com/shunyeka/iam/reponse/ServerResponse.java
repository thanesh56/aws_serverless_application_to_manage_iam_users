package com.shunyeka.iam.reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "ServerResponse",description = "Server Response The IAM User Information Along with Status Code")
public class ServerResponse {
    @ApiModelProperty(notes = "Status Code")
    String code;
    @ApiModelProperty(notes = "Short Description of Response")
    String message;
    @ApiModelProperty(notes = "Actual Data")
    Object data;
    @ApiModelProperty(notes = "Status")
    String status;


}