package com.jcg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public record PatchDto(String op, String key, String value) {
}
