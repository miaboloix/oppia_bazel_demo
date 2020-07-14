package com.google.android.bindingtest.no_moshi_test


data class GaeOutcome(
        val dest: String?,
        val refresher_exploration_id: String?,
        val feedback: GaeSubtitledHtml?,
        val param_changes: List<GaeParamChange>?,
        val missing_prerequisite_skill_id: String?,
        val labelled_as_correct: Boolean?
)