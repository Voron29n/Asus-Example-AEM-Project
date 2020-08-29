<template>
<div id="article_text-component-vue">
    <v-title :title-data="titleData"></v-title>
    <v-description :description-data="descriptionData"></v-description> 
</div>
</template>

<script>
import ArticleText_TitleCmp from './v-components/title/Title'
import ArticleText_DescriptionCmp from './v-components/description/Description'

export default {
    components: {
        "v-title": ArticleText_TitleCmp,
        "v-description": ArticleText_DescriptionCmp,
    },
    props: {
        textTitle: {
            type: String,
            required: false,
        },
        textDescription: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                textTitle: this.$props.textTitle,
            };
        },
        descriptionData() {
            return {
                textDescription: this.$props.textDescription,
            };
        },
    },
};

</script>

<style lang="scss" scoped>
@import "./v-style/article_text_default";
@import "./v-style/article_text_media";
</style>