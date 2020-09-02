import Vue from "vue";

Vue.component("vue_images-data", () =>
    import ( /* webpackChunkName: "ArticleImages" */ "@components/article/article-images/ArticleImages")
);