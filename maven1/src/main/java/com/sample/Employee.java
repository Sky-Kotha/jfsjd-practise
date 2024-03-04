package com.sample;

import org.springframework.stereotype.Component;

/**
 * Employee
 */
@Component
public record Employee(String name, Integer id, String skills) {
}