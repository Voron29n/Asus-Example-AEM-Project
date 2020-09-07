/* Vue global object */
import Vue from "vue";

/* Vue configuration */
Vue.config.devtools = true;

import { fetch } from 'whatwg-fetch';
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
    new ComponentData("#hot-product-groups_component-vue", "vue-hot-product-groups-data"),
    /* parsys group*/
    new ComponentData("#grid-parsys_desc-three-mobile-four-or-two_component-vue", "grid-parsys_desk3-mobile4-or-mobile2-data"),
    /* hero-banner group*/
    new ComponentData("#hero-banner-small_component-vue", "vue_hero-banner-small-data"),
    new ComponentData("#hero-banner-middle_component-vue", "vue_hero-banner-middle-data"),
    new ComponentData("#hero-banner-top_component-vue", "vue_hero-banner-top-data"),
    /* structure group*/
    new ComponentData("#footer_component-vue", "vue_footer-data"),
    new ComponentData("#nav-info-page_component-vue", "vue_nav-info-page-data"),
    /* article group*/
    new ComponentData("#article__title_component-vue", "vue_title-data"),
    new ComponentData("#article__image-text_component-vue", "vue_image-text-data"),
    new ComponentData("#article__text_component-vue", "vue_text-data"),
    new ComponentData("#article__image_component-vue", "vue_image-data"),
    new ComponentData("#article__images_component-vue", "vue_images-data"),
    new ComponentData("#customized-text_component-vue", "vue_customized-text-data"),
    /* proart group*/
    new ComponentData("#proart__hero-banner-top_component-vue", "vue_proart_hero-banner-top-data"),
    new ComponentData("#proart__products-nav_component-vue", "vue_products-nav-data"),
    new ComponentData("#proart__categories-nav_component-vue", "vue_categories-nav-data"),
];

/* Third step import Vue Component */
// import { injectVueComponent } from "./import/utils";


const main = document.querySelector(vueRootData.rootWrapperSelector);
main.id = vueRootData.rootIdValue;

async function getComponent(element) {
    switch (element.tagName) {
        case "vue_hero-banner-middle-data":
            element.innerHTML = await
            Vue.component("vue_hero-banner-middle-data", require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle").default);
            break;
        case "4":
            alert('В точку!');
            break;
        case 5:
            alert('Перебор');
            break;
        default:
            // alert("Нет таких значений");
    }
    return element;
};

vueArrayComponents.forEach((element) => {
    if (document.querySelector(element.tagName)) {
        // Vue.component("hero-banner-middle-data", require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle").default);
        getComponent(element).then(component => {
            main.appendChild(component);
        })
    }
});

/*
    Fourth step add id for div below body,
    because vue can't mount to <html> or <body> 
*/
// document.querySelector(vueRootData.rootWrapperSelector).id =
//     vueRootData.rootIdValue;
//   components: vueComponentObject,

new Vue({
    el: vueRootData.rootIdSelector,
    // components: vueComponentObject,
    template: vueRootData.rootIdSelector,
});