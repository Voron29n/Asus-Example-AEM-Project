import Vue from 'vue';

export async function getComponent(tagName) {
    let cmpVue;
    switch (tagName) {
        /* standart */
        case "vue_hot-product-groups-data":
            cmpVue = Vue.component(
                "vue_hot-product-groups-data",
                require("@components/standart/hot-product-groups/HotProductGroups")
                .default
            );
            break;
            /* parsys group*/
        case "grid-parsys_desk3-mobile4-or-mobile2-data":
            cmpVue = Vue.component(
                "grid-parsys_desk3-mobile4-or-mobile2-data",
                require("@components/parsys/grid-parsys-desc-3-mobile-4_or_2/GridParsys")
                .default
            );
            break;
            /* hero-banner group*/
        case "vue_hero-banner-small-data":
            cmpVue = Vue.component(
                "vue_hero-banner-small-data",
                require("@components/hero-banner/hero-banner-small/HeroBannerSmall")
                .default
            );
            break;
        case "vue_hero-banner-middle-data":
            cmpVue = Vue.component(
                "vue_hero-banner-middle-data",
                require("@components/hero-banner/hero-banner-middle/HeroBannerMiddle")
                .default
            );
            break;
        case "vue_hero-banner-top-data":
            cmpVue = Vue.component(
                "vue_hero-banner-top-data",
                require("@components/hero-banner/hero-banner-top/HeroBannerTop").default
            );
            break;
        case "vue_hero-banner-middle-list-data":
            cmpVue = Vue.component(
                "vue_hero-banner-middle-list-data",
                require("@components/hero-banner/hero-banner-middle-list/HeroBannerMiddleList").default
            );
            break;
            /* structure group*/
        case "vue_footer-data":
            cmpVue = Vue.component(
                "vue_footer-data",
                require("@components/structure/footer/Footer").default
            );
            break;
        case "vue_nav-info-page-data":
            cmpVue = Vue.component(
                "vue_nav-info-page-data",
                require("@components/structure/nav-info-page/NavInfoPage").default
            );
            break;
            /* article group*/
        case "vue_article_title-data":
            cmpVue = Vue.component(
                "vue_article_title-data",
                require("@components/article/article-title/ArticleTitle").default
            );
            break;
        case "vue_article_image-text-data":
            cmpVue = Vue.component(
                "vue_article_image-text-data",
                require("@components/article/article-image-text/ArticleImageText")
                .default
            );
            break;
        case "vue_article_text-data":
            cmpVue = Vue.component(
                "vue_article_text-data",
                require("@components/article/article-text/ArticleText").default
            );
            break;
        case "vue_article_image-data":
            cmpVue = Vue.component(
                "vue_article_image-data",
                require("@components/article/article-image/ArticleImage").default
            );
            break;
        case "vue_article_images-data":
            cmpVue = Vue.component(
                "vue_article_images-data",
                require("@components/article/article-images/ArticleImages").default
            );
            break;
        case "vue_article_customized-text-data":
            cmpVue = Vue.component(
                "vue_article_customized-text-data",
                require("@components/article/customized-text/CustomizedText").default
            );
            break;
            /* proart group*/
        case "vue_proart_hero-banner-top-data":
            cmpVue = Vue.component(
                "vue_proart_hero-banner-top-data",
                require("@components/proart/hero-banner-top/ProArtHeroBannerTop")
                .default
            );
            break;
        case "vue_proart_products-nav-data":
            cmpVue = Vue.component(
                "vue_proart_products-nav-data",
                require("@components/proart/products-nav/ProArtProductsNav").default
            );
            break;
        case "vue_proart_categories-nav-data":
            cmpVue = Vue.component(
                "vue_proart_categories-nav-data",
                require("@components/proart/categories-nav/ProArtCategoriesNav").default
            );
            break;
            /* proart professional group*/
        case "vue_proart_prof_hero-img-data":
            cmpVue = Vue.component(
                "vue_proart_prof_hero-img-data",
                require("@components/proart/professional/hero-img/ProArtProfHeroImg").default
            );
            break;
            /* product group*/
        case "vue_product-line-list-data":
            cmpVue = Vue.component(
                "vue_product-line-list-data",
                require("@components/product/product-line-list/ProductLineList")
                .default
            );
            break;
        default:
            console.log("Нет таких значений" + tagName);
    }
    return cmpVue;
}