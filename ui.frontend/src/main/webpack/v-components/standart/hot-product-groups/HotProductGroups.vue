<template>
    <div>
        <section class="cmc-hot-prod">
            <VueTitle :title-data="titleData"></VueTitle>
            <div class="commercial-inner">
                <VueProductGroups :product-groups-data="productGroupsData"></VueProductGroups>
            </div>
        </section>
    </div>
</template>

<script>
export default {
    name: "hot-product-groups-data",
    components: {
        "hot-product-groups-data": () => import( /* webpackChunkName: "HotProductGroups" */ './HotProductGroups.vue').then(m => m.default),
        VueTitle: () =>
            import(
                /* webpackChunkName: "HotProductGroups" */ "./v-components/title/Title"
            ),
        VueProductGroups: () =>
            import(
                /* webpackChunkName: "HotProductGroups" */ "./v-components/product-groups/ProductGroups"
            ),
    },
    props: {
        groupsTitle: {
            type: String,
            required: false,
        },
        hotProductsInfo: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                groupsTitle: this.$props.groupsTitle,
            };
        },
        productGroupsData() {
            return {
                hotProductsInfo: JSON.parse(this.$props.hotProductsInfo),
            };
        },
    },
};
</script>

<style lang="scss">
@import "./v-style/hot_product_groups_default";
@import "./v-style/hot_product_groups_media";
</style>
