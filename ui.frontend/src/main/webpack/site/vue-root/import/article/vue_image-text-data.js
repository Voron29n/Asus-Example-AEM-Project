import Vue from "vue";
let tagNameVue = "vue_image-text-data";

Vue.component(tagNameVue, require("@components/article/article-image-text/ArticleImageText"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ArticleImageText" */ "@components/article/article-image-text/ArticleImageText")
);