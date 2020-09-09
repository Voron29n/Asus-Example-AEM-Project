<template>
    <div class="section wd_section section_products" id="proart__productsNav">
        <div class="section_content">
            <div class="row">
                <div class="col l12 m12 s12 always__on__top">
                    <VueProducts :products-data="productsData"></VueProducts>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    components: {
        VueProducts: () =>
            import(
                /* webpackChunkName: "ProArtProductsNav" */ "./v-components/products/Products"
            ),
    },
    props: {
        productsNav: {
            type: String,
            required: false,
        },
    },
    computed: {
        productsData() {
            return {
                productsNav: JSON.parse(this.$props.productsNav),
            };
        },
    },
};

import (/* webpackChunkName: "ProArtProductsNav" */ './v-style/_products_nav_default.scss');
import (/* webpackChunkName: "ProArtProductsNav" */ './v-style/_products_nav_media.scss');
</script>
