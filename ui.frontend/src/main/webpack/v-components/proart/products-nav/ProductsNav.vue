<template>
    <div class="section wd_section section_products" id="proart__productsNav">
        <div class="section_content">
            <div class="row">
                <div class="col l12 m12 s12 always__on__top">
                    <v-products :products-data="productsData"></v-products>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ProductsData from "./v-components/products/Products";

export default {
    components: {
        "v-products": ProductsData,
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
</script>

<style lang="scss">
@import "./v-style/products_nav_default";
@import "./v-style/products_nav_media";
</style>
