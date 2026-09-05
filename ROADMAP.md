# ROADMAP: Nâng cấp Android 16 (API 36) cho ứng dụng

- [x] **Giai đoạn 1: Chuẩn bị môi trường & khảo sát**
  - [x] Kiểm tra SDK Android 16 (API 36) và JDK 17 trên máy tính.
  - [x] Sửa đường dẫn SDK trong `local.properties` và cấu hình JDK trong `gradle.properties`.
  - [x] Rà soát thư viện phụ thuộc và mã nguồn.
- [x] **Giai đoạn 2: Cập nhật Gradle, AGP và Kotlin**
  - [x] Nâng cấp Gradle Wrapper lên bản 8.12.
  - [x] Cập nhật AGP lên bản 8.9.1 (hỗ trợ compileSdk 36).
  - [x] Cập nhật Kotlin lên 2.1.0 và áp dụng plugin Compose compiler mới (`org.jetbrains.kotlin.plugin.compose`).
  - [x] Loại bỏ dependency/kapt không dùng tới (Hilt) để tránh xung đột build.
- [x] **Giai đoạn 3: Cập nhật cấu hình SDK mục tiêu & sửa mã nguồn**
  - [x] Cập nhật `compileSdk = 36` và `targetSdk = 36` trong `app/build.gradle.kts`.
  - [x] Cập nhật `buildToolsVersion = "36.0.0"`.
  - [x] Sửa lỗi sai package cũ `com.cmsbando.erp` sang `com.hnp.gplx600` trong `Home.kt`.
- [x] **Giai đoạn 4: Build & Xác thực**
  - [x] Chạy build thành công `assembleDebug`.
  - [x] Chạy build thành công `assembleRelease`.
  - [x] Kiểm tra và đối soát APK xuất ra bằng `aapt`, xác nhận `targetSdkVersion: '36'`, `compileSdkVersion: '36'`.
