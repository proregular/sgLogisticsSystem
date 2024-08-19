package com.sg.ls.dto;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TradeDTO {
	@NotNull(message = "코드를 입력해주세요")
	@NotEmpty(message = "코드를 입력해주세요")
	@NotBlank(message = "코드를 입력해주세요")
	@Max(value=30)
	private String trCd;
	@NotNull(message ="명칭을 입력해주세요")
	@NotEmpty(message = "명칭을 입력해주세요")
	@NotBlank(message = "명칭을 입력해주세요")
	private String trNm;
	private String ceoNm;
	private String addr;
	private String upte;
	private String trNum;
	private String tel;
	private String fax;
	private String jongmok;

}
