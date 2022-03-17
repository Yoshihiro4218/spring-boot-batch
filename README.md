# Spring Batch
## Batch とは
>データ処理におけるバッチ処理（バッチしょり）は、ひとまとまりのデータを一括して処理する方式である。逐次生み出されるデータを一定期間・一定量集めたものをバッチといい、このバッチ単位で処理をおこなう方式がバッチ処理である。
>比較される方式として、逐次生み出されるデータをストリームとして捉え到着したデータを順次扱うストリーム処理がある。データをキューイングせず即時処理するリアルタイム処理とも比較される。
>(引用: Wikipedia)

### Batch のメリット
* 大量のデータを一括で処理することができる
* 処理を夜間などのシステム負荷の少ない時間帯に実施することができる
* サービスを停止していればデータの整合性を容易に保てる

など

### Batch のデメリット
* 即時性がない
* データが想定より多いと終わりきれない可能性がある
    * サーバーやネットワークの負荷、実行時間などを考慮する必要がある

など

## Spring Batch 概要
### Spring Batch とは
>エンタープライズシステムの日々の運用に不可欠な堅牢なバッチアプリケーションの開発を可能にするために設計された、軽量で包括的なバッチフレームワーク。
>Spring Batch は、ロギング / トレース、トランザクション管理、ジョブ処理統計、ジョブの再起動、スキップ、リソース管理など、大量のレコードの処理に不可欠な再利用可能な機能を提供します。
>(引用: Spring 公式)

### Job, Step と Step の処理方式
>Spring BatchはJobという単位でバッチ処理を行います。
>Jobは複数のStepを順番に実行します。
>Stepには入力、処理、出力をひとまとまりに実行するChankと自由に処理を実行できるTaskletというふたつの種類があります。
>(引用: https://tech-lab.sios.jp/archives/11402)

![1](./img/1.png)
(引用: https://tech-lab.sios.jp/archives/11402)


## Spring Batch - Chunk を試してみる
### 内容
* `beforeUser.csv` のデータを読み取り、加工して DB の`after_user` テーブルに挿入
* 加工は、姓・名を分けて受け取っていたものを、繋げて name として DB に保存するということをしています(適当)

### 処理の流れ
* Job から Step が実行される
* chunk 単位でトランザクションを開始
* chunk サイズ(以下の場合は `10` )に達するまで `reader` , `processor` を繰り返す
    * `reader` : 入力データを取得
    * `processor` : 入力データに対する処理
* chunk サイズに達したら `writer` を実施
    * `writer` : chunk サイズ分のデータを出力 
* 正常に出力できたらコミット
* 例外が発生したらロールバック

```java
    @Bean
    public Step chunkStep() {
        log.info("ChunkStep !!");
        return stepBuilderFactory.get("step1")
                                 .<BeforeUser, AfterUser>chunk(10)
                                 .reader(chunkReader())
                                 .processor(chunkProcessor())
                                 .writer(chunkWriter())
                                 .build();
    }
```

TODO: tasklet, 中間コミット方式 と 一括コミット方式
















