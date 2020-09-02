import Vue from "vue";

Vue.component("vue_title-data", () =>
    import ( /* webpackChunkName: "ArticleTitle" */ "@components/article/article-title/ArticleTitle")
);