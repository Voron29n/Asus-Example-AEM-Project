import Vue from "vue";

Vue.component("vue_image-text-data", () =>
    import ( /* webpackChunkName: "ArticleImageText" */ "@components/article/article-image-text/ArticleImageText")
);