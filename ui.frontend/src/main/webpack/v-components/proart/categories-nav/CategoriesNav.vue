<template>
    <div id="proart__categoriesNav">
        <v-title :title-data="titleData"></v-title>
        <v-categories :categories-data="categoriesData"></v-categories>
    </div>
</template>

<script>
import CategoriesNav_ProductsDataCmp from "./v-components/title/Title";
import CategoriesNav_TitleDataCmp from "./v-components/categories/Categories";

export default {
    components: {
        "v-title": CategoriesNav_TitleDataCmp,
        "v-categories": CategoriesNav_ProductsDataCmp,
    },
    props: {
        categoriesTitle: {
            type: String,
            required: false,
        },
        categoriesNav: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                categoriesTitle: this.$props.categoriesTitle,
            };
        },
        productsData() {
            return {
                categoriesNav: JSON.parse(this.$props.categoriesNav),
            };
        },
    },
};
</script>

<style lang="scss">
@import "./v-style/categories_nav_default";
@import "./v-style/categories_nav_media";
</style>
