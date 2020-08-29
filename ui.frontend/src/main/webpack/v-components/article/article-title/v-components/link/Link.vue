<template>
    <div class="cmp_article_title-link" >
        <a :href="linkData.linkTo" :target="linkData.linkUrlTarget">{{linkData.descriptionLink}}</a>
    </div>
</template>

<script>

export default {
    props: {
        linkData: Object,
    },
};
</script>

<style lang="scss">
@import "./link_default";
@import "./link_media";
</style>