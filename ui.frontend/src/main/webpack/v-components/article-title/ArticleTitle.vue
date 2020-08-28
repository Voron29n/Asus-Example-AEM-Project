<template>
<div id="article_title-component-vue">
    <v-title :title-data="titleData"></v-title>
    <v-description :description-data="descriptionData"></v-description>
    <v-link :link-data="linkData"></v-link>
</div>
</template>

<script>
import ArticleTitle_TitleCmp from './v-components/title/Title'
import ArticleTitle_DescriptionCmp from './v-components/description/Description'
import ArticleTitle_LinkCmp from './v-components/link/Link'

export default {
    components: {
        "v-title": ArticleTitle_TitleCmp,
        "v-description": ArticleTitle_DescriptionCmp,
        "v-link": ArticleTitle_LinkCmp,
    },
    props: {
        title: {
            type: String,
            required: false,
        },
        titleDescription: {
            type: String,
            required: false,
        },
        descriptionLink: {
            type: String,
            required: false,
        },
        linkTo: {
            type: String,
            required: false,
        },
        linkUrlTarget: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                title: this.$props.title,
            };
        },
        descriptionData() {
            return {
                titleDescription: this.$props.titleDescription,
            };
        },
        linkData() {
            return {
                descriptionLink: this.$props.descriptionLink,
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
            };
        },
    },
};

</script>

<style lang="scss" scoped>
@import "./v-style/article_title_default";
@import "./v-style/article_title_media";
</style>