import Vue from "vue";
let tagNameVue = "vue_images-data";

Vue.component(tagNameVue, require("@components/article/article-images/ArticleImages"));
Vue.component(tagNameVue, () =>
    import ( /* webpackChunkName: "ArticleImages" */ "@components/article/article-images/ArticleImages")
);