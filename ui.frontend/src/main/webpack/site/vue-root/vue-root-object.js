/* Vue global object */
import Vue from "vue";

/* Vue configuration */
Vue.config.devtools = true;

/* Import custom class */
import { ComponentData } from "./ComponentData";

/* Default fields */
let vueArrayComponents = []; // Array for all created vue components
const vueComponentObject = {};
const vueRootData = {
    rootIdValue: "vue-root",
    rootIdSelector: "#vue-root",
    rootWrapperSelector: ".root.container.responsivegrid",
};

/* First what you need is import your components and you can use alias @components for this*/
import HeroBannerMiddle from "@components/hero-banner-middle/HeroBannerMiddle";
import HelloWorld from "@components/hello-world/HelloWorld";
import Footer from "@components/footer/Footer";
import NavInfoPage from "@components/nav-info-page/NavInfoPage";
import ArticleTitle from "@components/article-title/ArticleTitle";
import ArticleImageText from "@components/article-image-text/ArticleImageText";
import ArticleText from "@components/article-text/ArticleText";
import ArticleImage from "@components/article-image/ArticleImage";
import ArticleImages from "@components/article-images/ArticleImages";
import HotProductGroups from "@components/hot-product-groups/HotProductGroups";
import CustomizedText from "@components/customized-text/CustomizedText";
import GridParsys from "@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys";

/* Second step, you need add new Object with all vue components data at array */
vueArrayComponents = [
    new ComponentData(
        "hero-banner-middle" /* it is a name for custom tag that you can use at ui.app in component.html  */ ,
        "#hero-banner-middle-component-vue" /* it is a selector. This selector need to know if in the page we have our custom component */ ,
        HeroBannerMiddle /* it is a import Vue Component */
    ),
    new ComponentData("hello-world", "#hello-component-vue", HelloWorld),
    new ComponentData("vue-footer-data", "#footer-component-vue", Footer),
    new ComponentData("vue-navinfopage-data", "#nav_info_page-component-vue", NavInfoPage),
    new ComponentData("vue-title-data", "#article_title-component-vue", ArticleTitle),
    new ComponentData("vue-image-text-data", "#article_image-text-component-vue", ArticleImageText),
    new ComponentData("vue-text-data", "#article_text-component-vue", ArticleText),
    new ComponentData("vue-image-data", "#article_image-component-vue", ArticleImage),
    new ComponentData("vue-images-data", "#article_image-component-vue", ArticleImages),
    new ComponentData("vue-hot_product_groups-data", "#hot_product_groups-component-vue", HotProductGroups),
    new ComponentData("vue-customized_text-data", "#customized_text-component-vue", CustomizedText),
    new ComponentData("grid-parsys", "#grid-parsys-desc-three-mobile-four-or-two", GridParsys),
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