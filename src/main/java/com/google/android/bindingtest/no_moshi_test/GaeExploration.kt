package com.google.android.bindingtest.no_moshi_test

data class GaeExploration(
        val states: Map<String, GaeState>?,
        val param_changes: List<GaeParamChange>?,
        val param_specs: Map<String, GaeParamSpec>?,
        val init_state_name: String?,
        val objective: String?,
        val correctness_feedback_enabled: Boolean?,
        val title: String?
)