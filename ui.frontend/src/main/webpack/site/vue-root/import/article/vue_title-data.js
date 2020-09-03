import Vue from "vue";
let tagNameVue = "vue_title-data";

Vue.component(tagNameVue, require("@components/article/article-title/ArticleTitle"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ArticleTitle" */ "@components/article/article-title/ArticleTitle")
);