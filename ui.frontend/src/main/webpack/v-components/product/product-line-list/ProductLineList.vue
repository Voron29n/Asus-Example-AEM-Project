<template>
        <v-product-list
            :product-menu-bean="productMenuBean"
            :product-line-list="productLineListCollection"
        ></v-product-list>
</template>

<script>
import ProductLineList_ProductLineListComp from "./v-components/product-line-list/ProductLineListComp";

export default {
    components: {
        "v-product-list": ProductLineList_ProductLineListComp,
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
