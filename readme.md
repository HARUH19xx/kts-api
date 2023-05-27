概要<br>
・KotlinScriptで作成したAPI。<br>
フレームワークなどは使っていない。<br>

スクリプトとしての使用法<br>
・「kscript ファイル名」で使うことができる。<br>

Kotlinとしての使用法<br>
・Gradleを使用し、Kotlinに変換することができる。構文がほぼ同じであるため、修正は依存関係の整理にとどまり、容易に移行できる。そのため、コンパイラ言語としてのKotlinのビルドやテストを（ある程度）省き、高速に開発することができる。

備考<br>
・スクリプト全体を関数なしで記述する、変数をトップレベルで定義するといった、スクリプト言語に特有の記法には注意し、それをなるべく行わないこと。<br>
