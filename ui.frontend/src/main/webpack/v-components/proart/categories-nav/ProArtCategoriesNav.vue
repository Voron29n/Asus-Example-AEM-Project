<template>
    <div id="proart__categoriesNav" class="col l12 m12 s12 always__on__top">
        <VueTitle :title-data="categoriesTitleData"></VueTitle>
        <VueCategories :categories-data="categoriesNavData"></VueCategories>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ProArtCategoriesNav" */ "./v-components/title/Title"
            ),
        VueCategories: () =>
            import(
                /* webpackChunkName: "ProArtCategoriesNav" */ "./v-components/categories/Categories"
            ),
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
        categoriesTitleData() {
            return {
                categoriesTitle: this.$props.categoriesTitle,
            };
        },
        categoriesNavData() {
            return {
                categoriesNav: JSON.parse(this.$props.categoriesNav),
            };
        },
    },
};

import (/* webpackChunkName: "ProArtCategoriesNav" */ './v-style/_categories_nav_default.scss');
import (/* webpackChunkName: "ProArtCategoriesNav" */ './v-style/_categories_nav_media.scss');
</script>
