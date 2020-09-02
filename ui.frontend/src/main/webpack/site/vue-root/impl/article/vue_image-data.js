import Vue from "vue";

Vue.component("vue_image-data", () =>
    import ( /* webpackChunkName: "ArticleImage" */ "@components/article/article-image/ArticleImage")
);