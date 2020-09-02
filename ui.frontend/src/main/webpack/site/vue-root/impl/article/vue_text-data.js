import Vue from "vue";

Vue.component("vue_text-data", () =>
    import ( /* webpackChunkName: "ArticleText" */ "@components/article/article-text/ArticleText")
);