// var HeroBannerMiddleData = require("./hero-banner/hero-banner-middle-data.js");

let components = {
    // /* standart */
    // "vue_hot-product-groups-data": require("./standart/vue_hot-product-groups-data.js"),
    // /* parsys group*/
    // "grid-parsys_desk3-mobile4-or-mobile2-data": require("./parsys/grid-parsys_desk3-mobile4-or-mobile2-data.js"),
    // /* hero-banner group*/
    // "vue_hero-banner-small-data": require("./hero-banner/vue_hero-banner-small-data.js"),
    "hero-banner-middle-data": require("./hero-banner/hero-banner-middle-data.js"),
    // "vue_hero-banner-top-data": require("./hero-banner/vue_hero-banner-top-data.js"),
    /* structure group*/
    // "vue_footer-data": require("./structure/vue_footer-data.js"),
    // "vue_nav-info-page-data": require("./structure/vue_nav-info-page-data.js"),
    // /* article group*/
    // "vue_title-data": require("./article/vue_title-data.js"),
    // "vue_image-text-data": require("./article/vue_image-text-data.js"),
    // "vue_text-data": require("./article/vue_text-data.js"),
    // "vue_image-data": require("./article/vue_image-data.js"),
    // "vue_images-data": require("./article/vue_images-data.js"),
    // "vue_customized-text-data": require("./article/vue_customized-text-data.js"),
    // /* proart group*/
    // "vue_proart_hero-banner-top-data": require("./proart/vue_proart_hero-banner-top-data.js"),
    // "vue_products-nav-data": require("./proart/vue_products-nav-data.js"),
    // "vue_categories-nav-data": require("./proart/vue_categories-nav-data.js"),
};

export function injectVueComponent(tagName) {
    // return components[tagName];
    return components[tagName];
}