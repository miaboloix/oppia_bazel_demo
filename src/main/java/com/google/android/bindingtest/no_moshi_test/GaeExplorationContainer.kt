package com.google.android.bindingtest.no_moshi_test

data class GaeExplorationContainer(

        val record_playthrough_probability: Float?,
        val exploration_id: String?,
        val state_classifier_mapping: Map<String, GaeStateClassifier>?,
        val user_email: String?,
        val version: Int?,
        val correctness_feedback_enabled: Boolean?,
        val username: String?,
        val is_logged_in: Boolean?,
        val exploration: GaeExploration?,
        val session_id: String?

)