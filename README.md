# ShakeTorchSwitch - 懐中電灯アプリ

Android用の振動検知・懐中電灯制御アプリケーションです。加速度センサーを利用してデバイスの振動を検知し、フラッシュライト（懐中電灯）を自動で点灯・消灯します。

## 機能

### 🔦 主要機能
- **振動検知による自動点灯/消灯**: デバイスを振ると自動的にフラッシュライトがON/OFFします
- **手動制御**: ボタンでフラッシュライトを手動で制御可能
- **明るさ調整**: Android 13以降でフラッシュライトの明るさを調整可能（スライダー対応）
- **バックグラウンドサービス**: アプリを閉じても振動検知を継続
- **クイック設定タイル**: 通知パネルから素早くアクセス可能

### 📱 技術仕様
- **対応OS**: Android 9.0 (API Level 28) 以上
- **推奨OS**: Android 13 (API Level 33) 以上（明るさ調整機能を利用する場合）
- **UI**: Jetpack Compose
- **言語**: Kotlin

## スクリーンショット

*主な機能画面*
- フラッシュライトON/OFFボタン
- 明るさ調整スライダー
- バックグラウンドサービス制御

## インストール

### 必要な環境
- Android Studio (最新版推奨)
- JDK 11以上
- Android SDK API Level 36
- Gradle 8.x

### セットアップ手順

1. **リポジトリのクローン**
```bash
git clone https://github.com/eden10200/shakeTorchSwitch.git
cd shakeTorchSwitch
```

2. **Android Studioでプロジェクトを開く**
   - Android Studioを起動
   - "Open an Existing Project"を選択
   - クローンしたプロジェクトのディレクトリを選択

3. **SDK設定**
   - `local.properties`ファイルが自動生成されます
   - Android SDK のパスが正しく設定されているか確認

4. **ビルド＆実行**
   - 実機またはエミュレータを接続
   - Android Studioの"Run"ボタンをクリック
   - または、コマンドラインから:
```bash
./gradlew assembleDebug
```

## 使い方

### 基本操作

1. **アプリの起動**
   - アプリを起動すると、カメラ権限のリクエストが表示されます
   - 「許可」をタップして権限を付与してください

2. **手動でフラッシュライトを制御**
   - 「ON」ボタン: フラッシュライトを点灯
   - 「OFF」ボタン: フラッシュライトを消灯

3. **明るさの調整**（Android 13以上）
   - スライダーを操作してフラッシュライトの明るさを調整
   - レベル1（最小）〜デバイスの最大レベルまで調整可能

4. **振動検知モード**
   - 「START SERVICE」ボタンをタップ
   - デバイスを振ると自動的にフラッシュライトがON/OFFします
   - バックグラウンドでも動作します

5. **クイック設定タイルから使用**
   - 通知パネルを開く
   - 「編集」または設定アイコンをタップ
   - 「懐中電灯」タイルを追加
   - タイルをタップしてフラッシュライトをON/OFF

### 振動検知の設定

- **振動の閾値**: 80.0f（デフォルト）
- **検知間隔**: 1000ms（1秒）
- これらの値は`MainActivity.kt`で変更可能です

## パーミッション

このアプリは以下のパーミッションを使用します:

- `android.permission.CAMERA` - フラッシュライトの制御に必要
- `android.permission.FOREGROUND_SERVICE` - バックグラウンドサービスの実行に必要
- `android.permission.POST_NOTIFICATIONS` - 通知の表示に必要（Android 13以上）
- `android.permission.FOREGROUND_SERVICE_SPECIAL_USE` - フォアグラウンドサービスの特別な用途での使用

## プロジェクト構成

```
shakeTorchSwitch/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/shaketorchswitch/
│   │   │   │   ├── MainActivity.kt              # メインアクティビティ
│   │   │   │   ├── ShakeDetectionService.kt     # バックグラウンドサービス
│   │   │   │   ├── FlashlightTileService.kt     # クイック設定タイル
│   │   │   │   └── ui/components/               # UIコンポーネント
│   │   │   │       ├── BackgroundServiceControl.kt
│   │   │   │       ├── FlashLightButtons.kt
│   │   │   │       └── TorchBrightnessSlider.kt
│   │   │   ├── res/                             # リソースファイル
│   │   │   └── AndroidManifest.xml              # マニフェスト
│   │   └── androidTest/                         # テストコード
│   └── build.gradle                             # アプリレベルのビルド設定
├── gradle/                                      # Gradle設定
├── build.gradle                                 # プロジェクトレベルのビルド設定
├── settings.gradle                              # Gradleプロジェクト設定
└── README.md                                    # このファイル
```

## 主要なクラス

### MainActivity
- メインアクティビティ
- 加速度センサーのリスナー実装
- フラッシュライトの制御ロジック
- Jetpack Compose UI

### ShakeDetectionService
- バックグラウンドで振動検知を行うフォアグラウンドサービス
- 通知を表示してサービスの状態を通知

### FlashlightTileService
- クイック設定タイルの実装
- 通知パネルから素早くアクセス可能

## 依存関係

主な使用ライブラリ:
- Jetpack Compose - UI構築
- AndroidX Core KTX - Kotlin拡張機能
- Material3 - マテリアルデザイン3コンポーネント
- Lifecycle Runtime - ライフサイクル管理

詳細は`gradle/libs.versions.toml`を参照してください。

## トラブルシューティング

### フラッシュライトが点灯しない
- カメラ権限が付与されているか確認
- デバイスにフラッシュライト機能があるか確認
- 他のアプリがカメラを使用していないか確認

### 振動検知が動作しない
- 加速度センサーが搭載されているか確認
- 振動の強度を調整（閾値を下げる）
- バックグラウンドサービスが起動しているか確認

### 明るさ調整ができない
- Android 13 (API Level 33) 以上が必要
- デバイスがマルチレベルトーチをサポートしているか確認

## ビルドと開発

### デバッグビルド
```bash
./gradlew assembleDebug
```

### リリースビルド
```bash
./gradlew assembleRelease
```

### テストの実行
```bash
./gradlew test
```

### コード品質チェック
```bash
./gradlew lint
```

## 開発者

開発者: eden10200


