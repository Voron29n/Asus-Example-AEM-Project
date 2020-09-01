/* Vue global object */
import Vue from "vue";

/* Vue configuration */
Vue.config.devtools = true;

/* Import Custom Vue Plugin */
// import fetchPlugin from "@plugin/fetchPlugin.js";

/* Registration Custom Vue Plugin */
// Vue.use(fetchPlugin);

/* Import custom class */
import { ComponentData } from "./ComponentData";

/* Default fields */
let vueArrayComponents = []; // Array for all created vue components
const vueComponentObject = {};
// const vueComponentObject = [];
const vueRootData = {
    rootWrapperSelector: ".root.container.responsivegrid",
    rootIdValue: "vue-root",
    rootIdSelector: "#vue-root",
};

/* Second step, you need add new Object with all vue components data at array 
a name for custom tag(tagName) that you can use at ui.app in component.html 
a selector. This selector need to know if in the page we have our custom component
a import(importObject) Vue Component */

vueArrayComponents = [
    /* default */
    new ComponentData("vue-hot_product_groups-data", "#hot_product_groups-component-vue", '@components/standart/hot-product-groups/HotProductGroups'),
    /* Parsys Group*/
    new ComponentData("grid-parsys-desk3-mobile4-or-mobile2", "#grid-parsys-desc-three-mobile-four-or-two", '@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys'),
    /* Hero-banner Group*/
    new ComponentData("hero-banner-small", "#hero-banner-small-component-vue", '@components/hero-banner/hero-banner-small/HeroBannerSmall'),
    new ComponentData("hero-banner-middle", '#hero-banner-middle', '@components/hero-banner/hero-banner-middle/HeroBannerMiddle'),
    new ComponentData("vue-hero_banner_top-data", "#hero_banner_top-component-vue", '@components/hero-banner/hero-banner-top/HeroBannerTop'),
    /* Structure Group*/
    new ComponentData('vue-footer-data', "#footer-component-vue", '@components/structure/footer/Footer'),
    new ComponentData("vue-navinfopage-data", "#nav_info_page-component-vue", '@components/structure/nav-info-page/NavInfoPage'),
    /* Article Group*/
    new ComponentData("vue-title-data", "#article_title-component-vue", '@components/article/article-title/ArticleTitle'),
    new ComponentData("vue-image-text-data", "#article_image-text-component-vue", '@components/article/article-image-text/ArticleImageText'),
    new ComponentData("vue-text-data", "#article_text-component-vue", '@components/article/article-text/ArticleText'),
    new ComponentData("vue-image-data", "#article_image-component-vue", '@components/article/article-image/ArticleImage'),
    new ComponentData("vue-images-data", "#article_image-component-vue", '@components/article/article-images/ArticleImages'),
    new ComponentData("vue-customized_text-data", "#customized_text-component-vue", '@components/customized-text/CustomizedText'),
    /* ProArt Group*/
    new ComponentData("vue-proart__hero_banner_top-data", "#proart__hero_banner_top-component-vue", '@components/proart/hero-banner-top/HeroBannerTop'),
    new ComponentData("vue-products_nav-data", "#proart__products_nav-component-vue", '@components/proart/products-nav/ProductsNav'),
    new ComponentData("vue-categories_nav-data", "#proart__categories_nav-component-vue", '@components/proart/categories-nav/CategoriesNav'),
];

/* 
    Third step is create object with same structure:
    {
        tagName: importObject
    }
*/
import { cmp } from "./utils";

vueArrayComponents.forEach((element) => {
    if (document.querySelector(element.selector)) {
        cmp(element.tagName);
    }
});

/*
    Fourth step add id for div below body,
    because vue can't mount to <html> or <body> 
*/
document.querySelector(vueRootData.rootWrapperSelector).id =
    vueRootData.rootIdValue;

new Vue({
    el: vueRootData.rootIdSelector,
    // template: vueRootData.rootIdSelector,
});