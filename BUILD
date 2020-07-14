load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_android_library")
load("@rules_jvm_external//:defs.bzl", "artifact")
load("@dagger//:workspace_defs.bzl", "dagger_rules")

package(default_visibility = ["//visibility:public"])

load("@tools_android//tools/crashlytics:defs.bzl", "crashlytics_android_library")
load("@tools_android//tools/googleservices:defs.bzl", "google_services_xml")

GOOGLE_SERVICES_RESOURCES = google_services_xml(
    package_name = "org.oppia.app",
    google_services_json = "google-services.json",
)

crashlytics_android_library(
    name = "crashlytics_lib",
    package_name = "org.oppia.app",
    build_id = "ad1c9e31-7e13-4cb4-9391-9dcc2ab4c2da",
    resource_files = GOOGLE_SERVICES_RESOURCES,
)

android_library(
    name = "crashlytics_deps",
    exports = [
        artifact("com.crashlytics.sdk.android:crashlytics"),
        artifact("io.fabric.sdk.android:fabric"),
        artifact("com.google.gms:google-services:4.3.3"),
    ],
)

kt_android_library(
  name = "dagger_graph",
  custom_package = "com.google.android.bindingtest",
  srcs = [
    "src/main/java/com/google/android/bindingtest/dagger_test/SimpleComponent.kt",
    "src/main/java/com/google/android/bindingtest/dagger_test/SimpleModule.kt",
    "src/main/java/com/google/android/bindingtest/dagger_test/StringProvider.kt",
    "src/main/java/com/google/android/bindingtest/retrofit_gson_test/RequestApi.kt",
    "src/main/java/com/google/android/bindingtest/retrofit_gson_test/Rates.kt",
    "src/main/java/com/google/android/bindingtest/retrofit_gson_test/ExchangeResponse.kt",
  ],
  deps = [
    ":dagger",
    "@maven//:com_squareup_retrofit2_retrofit",
    "@maven//:com_squareup_retrofit2_converter_gson",
  ],
)

kt_android_library(
    name = "bindingtest_lib",
    custom_package = "com.google.android.bindingtest",
    srcs = [
      "src/main/java/com/google/android/bindingtest/MainActivity.kt",
    ],
    resource_files = glob(["src/main/res/**/*.xml", "src/main/res/**/*.png"]),
    manifest = "AndroidManifest.xml",
    deps = [
      ":dagger_graph",
    ],
)

java_import(
    name = "gson",
    jars = ["gson/gson-2.8.5.jar"],
)


android_binary(
    name = "bindingtest",
    custom_package = "org.oppia.app",
    manifest = "AndroidManifest.xml",
    deps = [
      ":bindingtest_lib",
      ":crashlytics_lib",
      ":crashlytics_deps",
    ],
)

dagger_rules()
