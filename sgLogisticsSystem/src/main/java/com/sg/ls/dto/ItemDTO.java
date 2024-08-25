package com.sg.ls.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ItemDTO {
	@NotBlank(message="코드를 입력해주세요.")
	@Size(max=8, message="8자 이하로 작성해주세요.")
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="영어 알파벳과 숫자만 입력할 수 있습니다.")
	private String itemCd;
	@NotBlank(message="명칭을 입력해주세요.")
	@Size(max=30, message="30자 이하로 작성해주세요.")
	@NotBlank(message="명칭을 입력해주세요.")
	private String itemNm;
	@Size(max=10, message="10자 이하로 작성해주세요.")
	private String itemSd;
	@Size(max=10, message="10자 이하로 작성해주세요.")
	private String itemDc;
	@Min(value=0, message="0 ~ 4 사이의 정수로 입력해주세요.")
	@Max(value=4, message="0 ~ 4 사이의 정수로 입력해주세요.")
	private Integer itemFg;
}
