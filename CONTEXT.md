# Bối cảnh dự án (CONTEXT.md)

## 1. Thông tin chung
- **Tên dự án:** CMSVERP (doctiengviet3 / com.hnp.gplx600)
- **Nền tảng:** Android (Native Jetpack Compose)
- **Ngôn ngữ:** Kotlin 2.1.0
- **Trạng thái hiện tại:** Đã nâng cấp thành công lên **Android 16 (API level 36)** và build thành công cả Debug và Release APK.

## 2. Trạng thái cấu hình sau khi nâng cấp
- **Compile SDK:** 36 (Android 16 - Baklava)
- **Target SDK:** 36 (Android 16 - Baklava)
- **Min SDK:** 24 (Android 7.0)
- **Build Tools Version:** 36.0.0
- **Gradle Wrapper:** 8.12
- **Android Gradle Plugin (AGP):** 8.9.1 (hỗ trợ đầy đủ Android 16)
- **Kotlin:** 2.1.0
- **Compose Compiler:** Dùng plugin chính thức `org.jetbrains.kotlin.plugin.compose` (Kotlin 2.1.0) thay cho extension cũ.
- **Java / JDK:** Microsoft OpenJDK 17 LTS (`C:\Program Files\Microsoft\jdk-17.0.20.101-hotspot`).
- **Android SDK:** `C:\Users\Admin\AppData\Local\Android\Sdk`.

## 3. Những thay đổi đối với mã nguồn & cấu hình
1. `local.properties`: Cập nhật `sdk.dir` về đúng thư mục SDK thực tế trên máy (`C:\Users\Admin\AppData\Local\Android\Sdk`).
2. `gradle.properties`: Thêm `org.gradle.java.home` trỏ tới Java 17 LTS.
3. `gradle/wrapper/gradle-wrapper.properties`: Cập nhật `distributionUrl` lên Gradle 8.12.
4. `build.gradle.kts` (root):
   - Nâng cấp `com.android.application` lên `8.9.1`.
   - Nâng cấp `org.jetbrains.kotlin.android` lên `2.1.0`.
   - Thêm `org.jetbrains.kotlin.plugin.compose` version `2.1.0`.
   - Gỡ bỏ plugin Hilt không dùng.
5. `app/build.gradle.kts`:
   - Bổ sung plugin `org.jetbrains.kotlin.plugin.compose`, gỡ `kotlin-kapt`.
   - Nâng `compileSdk = 36`, `targetSdk = 36`, `buildToolsVersion = "36.0.0"`.
   - Bỏ `composeOptions` và `ndkVersion` không cần thiết.
   - Cập nhật các thư viện AndroidX/Compose tương thích Kotlin 2.1.0 (Compose BOM 2024.12.01, Core-KTX 1.15.0, Lifecycle 2.8.7, Activity Compose 1.9.3, Navigation Compose 2.8.5).
   - Gỡ bỏ các dependency Hilt/Kapt không sử dụng.
6. `app/src/main/java/com/hnp/gplx600/pages/Home.kt`:
   - Sửa `package com.cmsbando.erp.pages` thành `package com.hnp.gplx600.pages`.
   - Sửa các import cũ từ `com.cmsbando.erp.*` sang `com.hnp.gplx600.*`.

## 4. Kết quả build và xác thực cuối cùng
- **Debug APK:** `app/build/outputs/apk/debug/app-debug.apk`
  - `compileSdkVersion='36'`
  - `targetSdkVersion='36'`
  - `platformBuildVersionCode='36'`
  - `platformBuildVersionName='16'`
- **Release APK:** `app/build/outputs/apk/release/app-release-unsigned.apk`
  - `compileSdkVersion='36'`
  - `targetSdkVersion='36'`
  - `platformBuildVersionCode='36'`
  - `platformBuildVersionName='16'`
