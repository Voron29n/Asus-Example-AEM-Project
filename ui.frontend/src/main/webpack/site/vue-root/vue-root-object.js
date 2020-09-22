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
    rootClassSelector: ".root",
    rootIdValue: "vue-root",
    rootIdSelector: "#vue-root",
    rootClassSelectorSecond: "body >div:first-child"
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
    new ComponentData(
        "#hero-banner-middle-list_component-vue",
        "vue_hero-banner-middle-list-data"
    ),
    /* structure group*/
    new ComponentData("#footer_component-vue", "vue_footer-data"),
    new ComponentData("#nav-info-page_component-vue", "vue_nav-info-page-data"),
    /* article group*/
    new ComponentData(
        "#article__title_component-vue",
        "vue_article_title-data"
    ),
    new ComponentData(
        "#article__image-text_component-vue",
        "vue_article_image-text-data"
    ),
    new ComponentData("#article__text_component-vue", "vue_article_text-data"),
    new ComponentData(
        "#article__image_component-vue",
        "vue_article_image-data"
    ),
    new ComponentData(
        "#article__images_component-vue",
        "vue_article_images-data"
    ),
    new ComponentData(
        "#article__customized-text_component-vue",
        "vue_article_customized-text-data"
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
    /* proart professional group*/
    new ComponentData(
        "#proart__prof__hero-img_component-vue",
        "vue_proart_prof_hero-img-data"
    ),
    new ComponentData(
        "#proart__prof__person-info_component-vue",
        "vue_proart_prof_person-info-data"
    ),
    new ComponentData(
        "#proart__prof__person-text_component-vue",
        "vue_proart_prof_person-text-data"
    ),
    /* product group */
    new ComponentData(
        "#product__product-line-list_component-vue",
        "vue_product-line-list-data"
    ),
];

/*
    Third step add id for div below body,
    because vue can't mount to <html> or <body> 
*/

if (document.querySelector(vueRootData.rootClassSelector) != null) {
    document.querySelector(vueRootData.rootClassSelector).id =
        vueRootData.rootIdValue;
} else if (document.querySelector(".xf-web-container > div")) {
    document.querySelector(".xf-web-container > div").id =
        vueRootData.rootIdValue;
}  

/* Fourth  step import Vue Component */
import { getComponent } from "./utils";

let pageComponents = {};

vueArrayComponents.forEach((element) => {
    if (document.querySelector(element.tagName)) {
        getComponent(element.tagName);
    }
});

Vue.config.ignoredElements = [
    "cq",
    // Use a `RegExp` to ignore all elements that start with "ion-"
    // 2.5+ only
    // /^ion-/
];

if (document.querySelector(vueRootData.rootIdSelector) != null) {
    new Vue({
        el: vueRootData.rootIdSelector,
        template: vueRootData.rootIdSelector,
    });
}

// var isNeedCreateNewVue = true;

// document.addEventListener("refreshVue", function(){

//     if (document.querySelector(vueRootData.rootClassSelector) != null) {
//         document.querySelector(vueRootData.rootClassSelector).id =
//             vueRootData.rootIdValue;
//     } else if (document.querySelector(".xf-web-container > div")) {
//         document.querySelector(".xf-web-container > div").id =
//             vueRootData.rootIdValue;
//     } else {
//         document.querySelector(vueRootData.rootClassSelectorSecond).id = vueRootData.rootIdValue;
//     }
    
//     /* Fourth  step import Vue Component */
//     debugger

//     // vueArrayComponents.forEach((element) => {
//     //     if (document.querySelector(element.tagName)) {
//     //         getComponent(element.tagName);
//     //     }
//     // });

//     if (isNeedCreateNewVue) {

//         getComponent("vue_proart_prof_hero-img-data");

//         new Vue({
//             el: vueRootData.rootIdSelector
//         });
//         isNeedCreateNewVue =false;

//     }

   
// })
