<template>
    <div>
        <a
            class="af-banner-small-link-block"
            :href="linkData.heroLink.linkTo"
            :target="linkData.heroLink.linkUrlTarget"
        ></a>
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