import express from "express";

const app = express();

//　静的ファイルのルーティング
app.use(express.static("./"));

app.listen(3000, () => {
    console.log("Server running on port 3000");
}
);