/* Vue global object */
import Vue from "vue";

/* Vue configuration */
Vue.config.devtools = true;

/* Import Custom Vue Plugin */
import fetchPlugin from "@plugin/fetchPlugin.js";

/* Registration Custom Vue Plugin */
Vue.use(fetchPlugin);

/* Import custom class */
import { ComponentData } from "./ComponentData";

/* Default fields */
let vueArrayComponents = []; // Array for all created vue components
const vueComponentObject = {};
const vueRootData = {
    rootWrapperSelector: ".root.container.responsivegrid",
    rootIdValue: "vue-root",
    rootIdSelector: "#vue-root",
};

/* First what you need is import your components and you can use alias @components for this*/
/* default */
import HotProductGroups from "@components/standart/hot-product-groups/HotProductGroups";
/* Parsys Group*/
import GridParsysDesk4Mobile4Or2 from "@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys";
import GridParsys from "@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys";
/* Hero-banner Group*/
import HeroBannerMiddle from "@components/hero-banner/hero-banner-middle/HeroBannerMiddle";
import HeroBannerSmall from "@components/hero-banner/hero-banner-small/HeroBannerSmall";
import HeroBannerTop from "@components/hero-banner/hero-banner-top/HeroBannerTop";
import HeroBannerMiddleList from "@components/hero-banner/hero-banner-middle-list/HeroBannerMiddleList";
/* Structure Group*/
import Footer from "@components/structure/footer/Footer";
import NavInfoPage from "@components/structure/nav-info-page/NavInfoPage";
/* Article Group*/
import ArticleTitle from "@components/article/article-title/ArticleTitle";
import ArticleImageText from "@components/article/article-image-text/ArticleImageText";
import ArticleText from "@components/article/article-text/ArticleText";
import ArticleImage from "@components/article/article-image/ArticleImage";
import ArticleImages from "@components/article/article-images/ArticleImages";
import CustomizedText from "@components/article/customized-text/CustomizedText";
/* ProArt Group*/
import ProArtHeroBannerTop from "@components/proart/hero-banner-top/HeroBannerTop";
import ProArtProductsNav from "@components/proart/products-nav/ProductsNav";
import ProArtCategoriesNav from "@components/proart/categories-nav/CategoriesNav";

/* Second step, you need add new Object with all vue components data at array */
vueArrayComponents = [
    new ComponentData(
        "hero-banner-middle" /* it is a name for custom tag(tagName) that you can use at ui.app in component.html  */ ,
        "#hero-banner-middle-component-vue" /* it is a selector. This selector need to know if in the page we have our custom component */ ,
        HeroBannerMiddle /* it is a import(importObject) Vue Component */
    ),
    new ComponentData("hero-banner-small", "#hero-banner-small-component-vue", HeroBannerSmall),
    new ComponentData("hero-banner-middle-list", "#hero_banner_middle_list-component-vue", HeroBannerMiddleList),
    new ComponentData("vue-hero_banner_top-data", "#hero_banner_top-component-vue", HeroBannerTop),
    new ComponentData("vue-footer-data", "#footer-component-vue", Footer),
    new ComponentData("grid-parsys-desk3-mobile4-or-mobile2", "#grid-parsys-desc-three-mobile-four-or-two", GridParsysDesk4Mobile4Or2),
    new ComponentData("vue-navinfopage-data", "#nav_info_page-component-vue", NavInfoPage),
    new ComponentData("vue-title-data", "#article_title-component-vue", ArticleTitle),
    new ComponentData("vue-image-text-data", "#article_image-text-component-vue", ArticleImageText),
    new ComponentData("vue-text-data", "#article_text-component-vue", ArticleText),
    new ComponentData("vue-image-data", "#article_image-component-vue", ArticleImage),
    new ComponentData("vue-images-data", "#article_image-component-vue", ArticleImages),
    new ComponentData("vue-hot_product_groups-data", "#hot_product_groups-component-vue", HotProductGroups),
    new ComponentData("vue-customized_text-data", "#customized_text-component-vue", CustomizedText),
    new ComponentData("grid-parsys", "#grid-parsys-desc-three-mobile-four-or-two", GridParsys),
    new ComponentData("vue-proart__hero_banner_top-data", "#proart__hero_banner_top-component-vue", ProArtHeroBannerTop),
    new ComponentData("vue-products_nav-data", "#proart__products_nav-component-vue", ProArtProductsNav),
    new ComponentData("vue-categories_nav-data", "#proart__categories_nav-component-vue", ProArtCategoriesNav),
];

/* 
    Third step is create object with same structure:
    {
        tagName: importObject
    }
*/
vueArrayComponents.forEach((element) => {
    if (document.querySelector(element.selector)) {
        vueComponentObject[element.tagName] = element.importObject;
    } else {
        console.log(
            "Can't find element with same selector:" + element.selector
        );
    }
});

/*
    Fourth step add id for div below body,
    because vue can't mount to <html> or <body> 
*/
document.querySelector(vueRootData.rootWrapperSelector).id =
    vueRootData.rootIdValue;

/* Final step create vue root object */
new Vue({
    el: vueRootData.rootIdSelector,
    components: vueComponentObject,
    template: vueRootData.rootIdSelector,
});