### クリーンアーキテクチャ解説

</br>

<span style="font-size: 80%">2018-10-30</span>

<span style="font-size: 80%">@orepuri</span>

---
### 本日の話

* クリーンアーキテクチャ解説

* コード例

* クリーンアーキテクチャ本を読んで

* クリーンアーキテクチャとDDD

---
### クリーンアーキテクチャ

The Clean Architecture

Robert C. Martin

https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

---
### クリーンアーキテクチャ

<img src="./images/clean-architecture.jpg" />

---
### Entities

<img src="./images/entities.jpg" />

---
### Entities
</br>
ビジネスルールをカプセル化

アプリケーションのビジネスオブジェクト

UIやDB, ユースケースなど外部の変更に影響しない(=依存しない)

---
### DDDでEntitiesに相当するもの
</br>
エンティティ

値オブジェクト

ドメインサービス

集約

---
### Use Cases

<img src="./images/usecases.jpg" />

---
### Use Cases
</br>
*アプリケーション固有の*ビジネスルール

エンティティを使ってユースケースを実現

必要に応じてDB等外部からデータ(エンティティ)を取得する

UIやDBなど外部の変更に影響しない(=依存しない)

---
### DDDでUse Casesに相当するもの
</br>
アプリケーションサービス


---
### Interface Adapters

<img src="./images/interface-adapters.jpg" />

---
### Interface Adapters
</br>
アダプタの集合

Controllers, Presenters, Gateways

ユースケースの入出力(Use Case Input/Outut Port)と</br>外部向けデータ(APIのJSONやDB)の相互変換



---
### Controllers
</br>
ユースケースを実行

外部からの入力データをユースケース向けの</br>入力(Use Case Input Port)に変換してユースケースに渡す


---
### Presenters
</br>
ユースケースの出力(Use Case Output Port)を<br/>外部向けのデータ(View model)に変換


---
### Gateways
</br>
DBアクセスや外部API呼び出しなど

DDDでのレポジトリ


---
### 重要なこと

<div id="left">
  <img src="./images/clean-architecture.jpg" />
</div>

<div id="right" style="text-align: center;">
</br>
<span style="font-size: 70%;">
各レイヤーが独立している
</span>
</br>
<span style="font-size: 70%;">
外側から内側への依存だけが許される
</span>
</br>
<span style="font-size: 70%;">
円中の矢印は制御の流れではなく</br>依存の方向
</span>
</div>

---
### レイヤーの独立性
</br>
レイヤーごとの変更やテストが容易になる

DBやWebフレームワークの変更が</br>エンティティやユースケースに影響しない

---
### 依存関係
</br>

*エンティティ*

何にも依存しないピュアなドメインモデル

</br>

*ユースケース*

エンティティだけに依存

</br>
*インタフェースアダプタ*

エンティティやユースケースに依存

---
### 詳細に依存しない
</br>

DBやWeb, フレームワークは詳細

大事なのはビジネス(ドメイン)ロジックで</br>それらが詳細に依存してはならない

---
### 疑問
</br>

*レイヤーは必ず4つ?*

レイヤーの数はいくつでもよい

大事なのはUIやDB, ビジネスロジックが分離されていること

</br>

*クリーンアーキテクチャで作るとクラス数が多すぎない?*

変更/テスト容易性とのトレードオフ

大規模なアプリケーションならやむを得ない

---
### 疑問
</br>

*UI(JS)でもクリーンアーキテクチャを取り入れられるか?*
</br>


できる(と思う)

ただし, VueJSやReactなどのフレームワークを使う場合</br>
その影響が大きいのでメリットよりもデメリットのほうが大きいかも

ドメインロジックが満載でドメインモデルが</br>
充実しているならメリットはありそう


---
### 疑問
</br>

*ユースケースでエンティティをDBから取得すると</br>依存関係が逆になるのでは?*

依存性逆転の原則を使う

---
### コード例

https://github.com/toracoya/clean-architecture-introduction/tree/master/src/main/scala/com/toracoya/example

---
### クリーンアーキテクチャ本を読んで
</br>

アーキテクチャの目的を確認

SOLIDの原則を理解

パッケージ分けの方針が見えてきた(ビルド/デプロイ可能な単位にする)

---
### クリーンアーキテクチャとDDD
</br>
クリーンアーキテクチャはアーキテクチャに焦点

アーキテクチャの目的である開発/デプロイ/運用/保守をサポートするために</br>
どう考えて設計すべきか書かれている

レイヤーを分けて開発しやすくするという点は同じ

---
### DDD
</br>

ドメインモデル中心の開発

</br>

クリーンアーキテクチャでのエンティティについて</br>さらに細かい分類がある

<span style="font-size: 70%">
エンティティ(DDDの), 値オブジェクト, ドメインサービス, 集約
</span>

</br>

戦略的設計

<span style="font-size: 70%">
ユビキタス言語, 境界づけられたコンテキスト, コンテキストマップ
</span>

---
### まとめ
</br>

クリーンアーキテクチャを解説

レイヤーに分離することで個々の変更が</br>お互いに与える影響を少なくできテストも容易になる

クリーンアーキテクチャとDDDはかぶる部分と</br>そうでない部分があるのでそれぞれ勉強しよう
