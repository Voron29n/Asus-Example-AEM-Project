<template>
        <VueProductList
            :product-menu-bean="productMenuBean"
            :product-line-list="productLineListCollection"
        ></VueProductList>
</template>

<script>
export default {
    components: {
        VueProductList: () =>
            import(
                /* webpackChunkName: "ProductLineList" */ "./v-components/product-line-list/ProductLineListComp"
            ),
    },
    props: {
        productMenuBeanJson: {
            type: String,
            required: false,
        },
        productLineListCollectionJson: {
            type: String,
            required: false,
        },
    },
    computed: {
        productMenuBean() {
            return JSON.parse(this.productMenuBeanJson);
        },
        productLineListCollection() {
            return JSON.parse(this.productLineListCollectionJson);
        },
    },
};
</script>
