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
const vueRootData = {
    rootWrapperSelector: ".root.container.responsivegrid",
    rootIdValue: "vue-root",
    rootIdSelector: "#vue-root",
};

/* Second step, you need add new Object with all vue components data at array 
selector need to know if in the page we have our custom component
name for custom tag(tagName) that you can use at ui.app in component.html */

vueArrayComponents = [
    /* standart */
    new ComponentData(
        "#hot-product-groups_component-vue",
        "vue_hot-product-groups-data"
    ),
    /* parsys group*/
    new ComponentData(
        "#grid-parsys_desc-three-mobile-four-or-two_component-vue",
        "grid-parsys_desk3-mobile4-or-mobile2-data"
    ),
    /* hero-banner group*/
    new ComponentData(
        "#hero-banner-small_component-vue",
        "vue_hero-banner-small-data"
    ),
    new ComponentData(
        "#hero-banner-middle_component-vue",
        "vue_hero-banner-middle-data"
    ),
    new ComponentData(
        "#hero-banner-top_component-vue",
        "vue_hero-banner-top-data"
    ),
    /* structure group*/
    new ComponentData("#footer_component-vue", "vue_footer-data"),
    new ComponentData("#nav-info-page_component-vue", "vue_nav-info-page-data"),
    /* article group*/
    new ComponentData("#article__title_component-vue", "vue_title-data"),
    new ComponentData(
        "#article__image-text_component-vue",
        "vue_image-text-data"
    ),
    new ComponentData("#article__text_component-vue", "vue_text-data"),
    new ComponentData("#article__image_component-vue", "vue_image-data"),
    new ComponentData("#article__images_component-vue", "vue_images-data"),
    new ComponentData(
        "#customized-text_component-vue",
        "vue_customized-text-data"
    ),
    /* proart group*/
    new ComponentData(
        "#proart__hero-banner-top_component-vue",
        "vue_proart_hero-banner-top-data"
    ),
    new ComponentData(
        "#proart__products-nav_component-vue",
        "vue_proart_products-nav-data"
    ),
    new ComponentData(
        "#proart__categories-nav_component-vue",
        "vue_proart_categories-nav-data"
    ),
];

/*
    Third step add id for div below body,
    because vue can't mount to <html> or <body> 
*/
const main = document.querySelector(vueRootData.rootWrapperSelector);
main.id = vueRootData.rootIdValue;

/* Fourth  step import Vue Component */
// import { getComponent } from "./utils";

async function getComponent(element) {
    switch (element.tagName) {
        /* standart */
        case "vue_hot-product-groups-data":
            await Vue.component(
                "vue_hot-product-groups-data",
                require("@components/standart/hot-product-groups/HotProductGroups")
                .default
            );
            break;
            /* parsys group*/
        case "grid-parsys_desk3-mobile4-or-mobile2-data":
            await Vue.component(
                "grid-parsys_desk3-mobile4-or-mobile2-data",
                require("@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys")
                .default
            );
            break;
            /* hero-banner group*/
        case "vue_hero-banner-small-data":
            await Vue.component(
                "vue_hero-banner-small-data",
                require("@components/hero-banner/hero-banner-small/HeroBannerSmall")
                .default
            );
            break;
        case "vue_hero-banner-middle-data":
            await Vue.component(
                "vue_hero-banner-middle-data",
                require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
                .default
            );
            break;
        case "vue_hero-banner-top-data":
            await Vue.component(
                "vue_hero-banner-top-data",
                require("@components/hero-banner/hero-banner-top/HeroBannerTop").default
            );
            break;
            /* structure group*/
        case "vue_footer-data":
            await Vue.component(
                "vue_footer-data",
                require("@components/structure/footer/Footer").default
            );
            break;
        case "vue_nav-info-page-data":
            await Vue.component(
                "vue_nav-info-page-data",
                require("@components/structure/nav-info-page/NavInfoPage").default
            );
            break;
            /* article group*/
        case "vue_article_title-data":
            await Vue.component(
                "vue_article_title-data",
                require("@components/article/article-title/ArticleTitle").default
            );
            break;
        case "vue_article_image-text-data":
            await Vue.component(
                "vue_article_image-text-data",
                require("@components/article/article-image-text/ArticleImageText")
                .default
            );
            break;
        case "vue_article_text-data":
            await Vue.component(
                "vue_article_text-data",
                require("@components/article/article-text/ArticleText").default
            );
            break;
        case "vue_article_image-data":
            await Vue.component(
                "vue_article_image-data",
                require("@components/article/article-image/ArticleImage").default
            );
            break;
        case "vue_article_images-data":
            await Vue.component(
                "vue_article_images-data",
                require("@components/article/article-images/ArticleImages").default
            );
            break;
        case "vue_article_customized-text-data":
            await Vue.component(
                "vue_article_customized-text-data",
                require("@components/article/customized-text/CustomizedText").default
            );
            break;
            /* proart group*/
        case "vue_proart_hero-banner-top-data":
            await Vue.component(
                "vue_proart_hero-banner-top-data",
                require("@components/proart/hero-banner-top/ProArtHeroBannerTop")
                .default
            );
            break;
        case "vue_proart_products-nav-data":
            await Vue.component(
                "vue_proart_products-nav-data",
                require("@components/proart/products-nav/ProArtProductsNav").default
            );
            break;
        case "vue_proart_categories-nav-data":
            await Vue.component(
                "vue_proart_categories-nav-data",
                require("@components/proart/categories-nav/ProArtCategoriesNav").default
            );
            break;
        default:
            // alert("Нет таких значений");
    }
    // return element;
}

vueArrayComponents.forEach((element) => {
    if (document.querySelector(element.tagName)) {
        // getComponent(element).then(component => {
        //     main.appendChild(component);
        // })
        getComponent(element);
    }
});

new Vue({
    el: vueRootData.rootIdSelector,
    // components: vueComponentObject,
    template: vueRootData.rootIdSelector,
});