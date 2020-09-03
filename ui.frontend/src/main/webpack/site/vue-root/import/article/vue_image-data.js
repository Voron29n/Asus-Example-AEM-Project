import Vue from "vue";
let tagNameVue = "vue_image-data";

Vue.component(tagNameVue, require("@components/article/article-image/ArticleImage"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ArticleImage" */ "@components/article/article-image/ArticleImage")
);