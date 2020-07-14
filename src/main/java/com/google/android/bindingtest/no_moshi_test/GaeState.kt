package com.google.android.bindingtest.no_moshi_test

data class GaeState(
        val recorded_voiceovers: GaeRecordedVoiceovers?,
        val content: GaeSubtitledHtml?,
        val written_translations: GaeWrittenTranslations?,
        val param_changes: List<GaeParamChange>?,
        val classifier_model_id: String?,
        val interaction: GaeInteractionInstance?,
        val solicit_answer_details: Boolean?
)