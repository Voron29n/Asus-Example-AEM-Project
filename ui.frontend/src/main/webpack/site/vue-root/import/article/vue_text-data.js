import Vue from "vue";
let tagNameVue = "vue_text-data";

Vue.component(tagNameVue, require("@components/article/article-text/ArticleText"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ArticleText" */ "@components/article/article-text/ArticleText")
);