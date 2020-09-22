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
    data() {
        return {
            productLineList: null
        }
    },
    props: {
        resourcePath: {
            type: String,
            required: false,
        },
        productMenuBeanJson: {
            type: String,
            required: false,
        },
        productLineListCollectionJson: {
            type: String,
            required: false,
        },
    },
    methods: {
        async getProductLineList() {
            let response = await this.$_GET_MODEL(this.resourcePath);
            if (!response.ok) {
                console.log("fetch request failed");
            } else {
                console.log("fetch request OK");
                let responceJson = await response.json();
                this.productLineList = responceJson.productLineList;
            }
        }
    },
    mounted () {
        this.getProductLineList();
    },
    computed: {
        productMenuBean() {
            return JSON.parse(this.productMenuBeanJson);
        },
        productLineListCollection() {
            return this.productLineList != null ? this.productLineList : JSON.parse(this.productLineListCollectionJson);
        },
    },
};
</script>
