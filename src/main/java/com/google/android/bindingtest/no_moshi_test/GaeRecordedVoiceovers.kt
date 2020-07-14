package com.google.android.bindingtest.no_moshi_test

data class GaeRecordedVoiceovers(
        val voiceovers_mapping: Map<String, Map<String, GaeVoiceover>>?
)