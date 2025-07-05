package com.spa.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartProjectAnalyzerWebApplication

fun main(args: Array<String>) {
    runApplication<SmartProjectAnalyzerWebApplication>(*args)
} 