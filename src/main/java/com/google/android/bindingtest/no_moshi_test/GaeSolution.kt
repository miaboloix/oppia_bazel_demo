package com.google.android.bindingtest.no_moshi_test

/**
 * Data class for Solution model
 * https://github.com/oppia/oppia/blob/15516a/core/domain/state_domain.py#L221
 */

data class GaeSolution(
        val interaction_id: String?,
        val answer_is_exclusive: Boolean?,
        val correct_answer: String?,
        val explanation: GaeSubtitledHtml?
)